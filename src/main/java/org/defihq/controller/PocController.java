package org.defihq.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.defihq.service.RedisService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class RedisController {

    @PostMapping("/postRecord")
    public CompletableFuture<String> postRecord(@RequestBody JsonNode documentDetails) throws RuntimeException {
        log.info("Path: postRecord");
        return CompletableFuture.supplyAsync(() -> {
            log.info(documentDetails.toString());
            try {
                return Objects.requireNonNull(RedisService.postRedisRecord(documentDetails.get("key").toString(),
                        documentDetails.get("value").toString())).getJsonData();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

}