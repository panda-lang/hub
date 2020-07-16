/*
 * Copyright (c) 2018-2019 Hub Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.utils;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public final class FilesUtils {

    public static boolean storeFile(Path path, MultipartFile file, boolean xmlAllowed) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path directoryPath = path.resolve(fileName);

        if (!xmlAllowed && FilenameUtils.getExtension(file.getOriginalFilename()).contains("xml")) {
            return false;
        }

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), directoryPath.toFile());
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static @Nullable File getMostRecentDirectory(Path directoryPath) {
        return Arrays.stream(Objects.requireNonNull(directoryPath.toFile().listFiles()))
                .filter(File::isDirectory)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }

    public static boolean writeFileChecksums(Path path) {
        try {
            Files.touch(new File(path + ".md5"));
            Files.touch(new File(path + ".sha1"));

            Path md5FileFile = Paths.get(path + ".md5");
            Path sha1FileFile = Paths.get(path + ".sha1");

            FileUtils.writeStringToFile(md5FileFile.toFile(), Files.hash(md5FileFile.toFile(), Hashing.md5()).toString(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(sha1FileFile.toFile(), Files.hash(sha1FileFile.toFile(), Hashing.sha1()).toString(), StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private FilesUtils() { }

}
