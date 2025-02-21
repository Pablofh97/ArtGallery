package com.example.artgallery

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ArtGalleryTests {
    //Test the borderline cases
    @Test
    fun caculateNextImage() {
        var result = 14
        result = nextImage(result)
        assertEquals(1,result)
    }

    @Test
    fun calculatePreviousImage() {
        var result = 1
        result = previousImage(result)
        assertEquals(14,result)
    }
    @Test
    fun calculateTwoPreviousOneNextImage() {
        var result = 1
        result = previousImage(result)
        result = previousImage(result)
        result = nextImage(result)
        assertEquals(14,result)
    }
}