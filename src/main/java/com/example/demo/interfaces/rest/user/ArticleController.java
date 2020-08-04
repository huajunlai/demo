package com.example.demo.interfaces.rest.user;

import com.example.demo.interfaces.rest.user.command.ArticleQueryIdCommand;
import com.example.demo.interfaces.rest.user.representation.ArticleQueryIdRepresentation;
import com.example.demo.service.user.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.constraints.NotNull;

/**
 * ArticleController.
 * 2020/7/31 下午 02:38
 *
 * @author Lai
 * @version 1.0.0
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    /**
     * ArticleService.
     */
    @NotNull
    private final ArticleService articleService;

    @PostMapping("query")
    public ResponseEntity<ArticleQueryIdRepresentation> query(
            @RequestBody final ArticleQueryIdCommand command
    ) throws NoResultException {
        ArticleQueryIdRepresentation response = articleService
                .findArticleById(
                        command
                );
        return ResponseEntity.ok(response);
    }
}
