package org.panda_lang.reposilite.utils;

import org.bson.types.ObjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractCrudRestControllerIntegrationTest {

    @Autowired
    private TestEntityController testEntityController;

    @Autowired
    private TestEntityRepository testEntityRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.testEntityController).build();
    }

    @Test
    public void getByNameShouldReturn404WhenNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/by-name/{name}", "test2115"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getByIdShouldReturn404WhenNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/by-id/{id}", ObjectId.get().toHexString()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getByNameShouldReturn200WhenUserFound() throws Exception {
        ObjectId id = ObjectId.get();
        this.testEntityRepository.save(new TestEntity(id, "test2116"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/by-name/{name}", "test2116"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("test2116")));
    }

    @Test
    public void getByIdShouldReturn200WhenUserFound() throws Exception {
        ObjectId id = ObjectId.get();
        this.testEntityRepository.save(new TestEntity(id, "test2117"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/by-id/{id}", id.toHexString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("test2117")));
    }

    // TODO Abstract CRUD Operations Refactor

}

@RestController
@RequestMapping("/api/tests")
class TestEntityController extends AbstractCrudRestController<TestEntity> {

    public TestEntityController(@Autowired TestEntityRepository repository) {
        super(repository);
    }

}

@Repository
interface TestEntityRepository extends NameableMongoRepository<TestEntity, ObjectId> {

}


@Document("tests")
class TestEntity implements IdentifiableEntity<ObjectId> {

    @Id
    private ObjectId identifier;
    private String name;

    public TestEntity(ObjectId identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    @Override
    public ObjectId getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

}
