package com.thevarungupta.spring.boot.kotlin.app.entity

import javax.persistence.*

@Entity
@Table(name = "courses")
data class Course(
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    val id: Int?,
    var name: String,
    var category: String
)
