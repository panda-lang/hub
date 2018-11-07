package org.panda_lang.reposilite.depository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such repository found")
class DepositoryNotFoundException extends RuntimeException {

}
