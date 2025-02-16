package com.example.artgallery

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ArtGalleryTests {
    //En los test pruebo los casos límites
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
}