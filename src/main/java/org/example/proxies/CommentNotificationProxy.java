package org.example.proxies;

import org.example.repositories.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
