package com.thevarungupta.spring.boot.kotlin.app.controller

import com.thevarungupta.spring.boot.kotlin.app.dto.CourseDTO
import com.thevarungupta.spring.boot.kotlin.app.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/courses")
@RestController
class CourseController(
    val courseService: CourseService
) {

   @PostMapping
    fun addCourse(@RequestBody courseDTO: CourseDTO): CourseDTO{
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    fun getCourses(@RequestParam("course_name", required = false) courseName: String?): List<CourseDTO>
     = courseService.getAllCourses(courseName)

    @PutMapping("/{courseId}")
    fun updateCourse(@RequestBody courseDto: CourseDTO, @PathVariable("courseId") courseId: Int): CourseDTO
     = courseService.updateCourse(courseId, courseDto)

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable("courseId") courseId: Int)
     = courseService.deleteCourse(courseId)

}