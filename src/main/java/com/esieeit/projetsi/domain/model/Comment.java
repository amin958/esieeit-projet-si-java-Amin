package com.esieeit.projetsi.domain.model;

import com.esieeit.projetsi.domain.validation.Validators;

public class Comment {
    private Long id;
    private String content;
    private Task task;
    private User author;

    public Comment(String content, Task task, User author) {
        this.content = Validators.requireNonBlank(content, "contenu du commentaire", 1, 500);
        Validators.requireNonNull(task, "tâche associée");
        Validators.requireNonNull(author, "auteur du commentaire");
        this.task = task;
        this.author = author;
    }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public void setId(Long id) { this.id = id; }

    @Override
    public String toString() {
        return "Comment{author=" + author.getUsername() + ", content='" + content + "'}";
    }
    // Ajoute ces getters pour que VS Code voit que tu utilises ces objets
    public Task getTask() {
        return task;
    }

    public User getAuthor() {
        return author;
    }
}