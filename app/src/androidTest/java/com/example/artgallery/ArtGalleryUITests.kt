package com.example.artgallery

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.artgallery.ui.theme.ArtGalleryTheme
import org.junit.Rule
import org.junit.Test

class ArtGalleryUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun previousImage() {
        composeTestRule.setContent {
            ArtGalleryTheme {
                PlayerPanel()
            }
        }
        // Obtener el contexto de la prueba
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedText = context.getString(R.string.lewandowski) // Obtener el texto real
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText(expectedText).assertExists() // Buscar por el string real
    }

    @Test
    fun nextImage() {
        composeTestRule.setContent {
            ArtGalleryTheme {
                PlayerPanel()
            }
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedText = context.getString(R.string.szczesny) // Obtener el texto real
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText(expectedText).assertExists() // Buscar por el string real
    }

    @Test
    fun previousAndThreeTimeNext() {
        composeTestRule.setContent {
            ArtGalleryTheme {
                PlayerPanel()
            }
        }

        // Simular 3 clics en "Next"
        repeat(3) {
            composeTestRule.onNodeWithText("Next").assertExists().performClick()
        }

        // Simular 1 clic en "Previous"
        composeTestRule.onNodeWithText("Previous").assertExists().performClick()
        // Verificar que la imagen esperada aparece en la UI
        composeTestRule.onNodeWithText("Araujo (Central)").assertExists()
    }
}