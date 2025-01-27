package org.example;

import org.example.config.ProjectConfiguration;
import org.example.repositories.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}