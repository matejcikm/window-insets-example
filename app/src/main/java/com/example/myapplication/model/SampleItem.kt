package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleItem(
    val id: Int,
    val title: String,
    val url: String
): Parcelable {
    companion object {
        val DATA = listOf(
            SampleItem(
                id = 0,
                title = "Basic Blocks and Woodturning",
                url = "https://source.unsplash.com/oJ7SV6vQfBA"
            ),
            SampleItem(
                id = 1,
                title = "An Introduction To Oil Painting On Canvas",
                url = "https://source.unsplash.com/W9_sznrBmoA"
            ),
            SampleItem(
                id = 2,
                title = "Understanding the Composition of Modern Cities",
                url = "https://source.unsplash.com/s4I1xpX_ny8"
            ),
            SampleItem(
                id = 3,
                title = "Learning The Basics of Brand Identity",
                url = "https://source.unsplash.com/G9_Euqxpu4k"
            ),
            SampleItem(
                id = 4,
                title = "Wooden Materials and Sculpting Machinery",
                url = "https://source.unsplash.com/o54RjF-C7xo"
            ),
            SampleItem(
                id = 5,
                title = "Advanced Potter's Wheel",
                url = "https://source.unsplash.com/-LHvba-FgAo"
            ),
            SampleItem(
                id = 6,
                title = "Advanced Abstract Shapes & 3D Printing",
                url = "https://source.unsplash.com/HQkz_lWT_lY"
            ),
            SampleItem(
                id = 7,
                title = "Beginning Portraiture",
                url = "https://source.unsplash.com/LE0Hp8l9gvs"
            ),
            SampleItem(
                id = 8,
                title = "Intermediate Knife Skills",
                url = "https://source.unsplash.com/f1xj_KeZ5RM"
            ),
            SampleItem(
                id = 9,
                title = "Pattern Making for Beginners",
                url = "https://source.unsplash.com/hew8-OoUriU"
            ),
            SampleItem(
                id = 10,
                title = "Location Lighting for Beginners",
                url = "https://source.unsplash.com/pPxJTtxfV1A"
            ),
            SampleItem(
                id = 11,
                title = "Cinematography & Lighting",
                url = "https://source.unsplash.com/oIf4VCDztZY"
            ),
            SampleItem(
                id = 12,
                title = "Monuments, Buildings & Other Structures",
                url = "https://source.unsplash.com/KxCJXXGsv9I"
            )
        )
    }
}

