package com.example.appvacinfo.model

data class Vaccine(
    var name: String,
    var description: String,
    var doses: String,
    var diseasesAvoided: List<String>
)