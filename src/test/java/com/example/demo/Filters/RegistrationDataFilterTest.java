package com.example.demo.Filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationDataFilterTest {
    RegistrationDataFilter filter = new RegistrationDataFilter();
    @Test
    void arePasswordsCorrect() {
        assertFalse(filter.CorrectPassword("qwertyyy", "qwertyyy"));
        assertFalse(filter.CorrectPassword("", ""));
        assertFalse(filter.CorrectPassword("qwerty123", "qwerty123"));
        assertFalse(filter.CorrectPassword("qwerty123^^", "123qwerty^^"));
        assertTrue(filter.CorrectPassword("StrongPassword12!", "StrongPassword12!"));
        assertTrue(filter.CorrectPassword("@notherSo1id", "@notherSo1id"));
    }

    @Test
    void isUserNameCorrect() {
        assertFalse(filter.CorrectUsername("Adaś"));
        assertFalse(filter.CorrectUsername(""));
        assertFalse(filter.CorrectUsername("!YEEEEEET!"));
        assertFalse(filter.CorrectUsername("qwertyuiopasdfghjklzxcvbnm"));
        assertTrue(filter.CorrectUsername("TypicalUsername"));
        assertTrue(filter.CorrectUsername("my_favorite_username"));
    }

    @Test
    void isEmailCorrect() {
        assertFalse(filter.CorrectEmail("not an email"));
        assertFalse(filter.CorrectEmail(""));
        assertFalse(filter.CorrectEmail("not.@n.email.too"));
        assertTrue(filter.CorrectEmail("example.email@gmail.com"));
    }

}