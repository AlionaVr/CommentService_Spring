package org.example;

import org.example.config.ProjectConfiguration;
import org.example.repositories.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var service = context.getBean(CommentService.class);

        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
    }
}