package org.example.services;

import org.example.proxies.CommentNotificationProxy;
import org.example.repositories.Comment;
import org.example.repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    // this class has only one constructor, that's why @Autowired is not needed
    public CommentService(CommentRepository commentRepository,CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
