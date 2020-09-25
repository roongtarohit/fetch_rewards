package com.example.fetch_rewards.restservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PyramidServiceTest {

    @Test
    public void Pyramid_ReturnsTrue_OnValidInput() throws PyramidException {
        PyramidService subject = new PyramidService("banana");
        assertTrue(subject.isPyramid());
    }

    @Test
    public void Pyramid_ReturnsTrue_OnValidInputWithWhitespace() throws PyramidException {
        PyramidService subject = new PyramidService("  banana ");
        assertTrue(subject.isPyramid());
    }

    @Test
    public void Pyramid_ReturnsTrue_OnMixingLetterCaseValidInput() throws PyramidException {
        PyramidService subject = new PyramidService("  DaNdaNanBn ");
        assertTrue(subject.isPyramid());
    }

    @Test
    public void Pyramid_ReturnsFalse_OnInvalidInput() throws PyramidException {
        PyramidService subject = new PyramidService("bandana");
        assertFalse(subject.isPyramid());
    }

    @Test
    public void Pyramid_ReturnsFalse_OnInvalidInput2() throws PyramidException {
        PyramidService subject = new PyramidService("bbananaan");
        assertFalse(subject.isPyramid());
    }

    @Test
    public void Pyramid_ThrowsException_OnEmptyString()  {
        PyramidService subject = new PyramidService("");
        assertThrows(PyramidException.class, subject::isPyramid);
    }

    @Test
    public void Pyramid_ThrowsException_OnNull() {
        PyramidService subject = new PyramidService(null);
        assertThrows(PyramidException.class, subject::isPyramid);
    }

    @Test
    public void Pyramid_ThrowsException_OnWhitespace() {
        PyramidService subject = new PyramidService(" ");
        assertThrows(PyramidException.class, subject::isPyramid);
    }

    @Test
    public void Pyramid_ThrowsException_WhenContainsNumber() {
        PyramidService subject = new PyramidService(" Rohit12Roongta");
        assertThrows(PyramidException.class, subject::isPyramid);
    }

    @Test
    public void Pyramid_ThrowsException_WhenContainsSpecialCharacter() {
        PyramidService subject = new PyramidService(" RohitRoongta?");
        assertThrows(PyramidException.class, subject::isPyramid);
    }

}
