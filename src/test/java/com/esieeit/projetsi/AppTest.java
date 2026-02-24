package com.esieeit.projetsi; // Mets le MÊME package ici

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void appHasGreeting() {
        App classUnderTest = new App(); // Maintenant il va le trouver !
        assertNotNull(classUnderTest, "L'application doit pouvoir être initialisée");
    }
}