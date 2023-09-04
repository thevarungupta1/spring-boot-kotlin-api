package com.thevarungupta.spring.boot.kotlin.app.service

import com.thevarungupta.spring.boot.kotlin.app.dto.CourseDTO
import com.thevarungupta.spring.boot.kotlin.app.entity.Course
import com.thevarungupta.spring.boot.kotlin.app.exception.CourseNotFoundException
import com.thevarungupta.spring.boot.kotlin.app.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    val courseRepository: CourseRepository
) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO{
        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }
        courseRepository.save(courseEntity)
        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }

    // get
    fun getAllCourses(courseName:String?):List<CourseDTO>{
        val courses = courseName?.let {
            courseRepository.findCoursesByName(courseName)
        } ?: courseRepository.findAll()

        return courses
            .map {
                CourseDTO(it.id, it.name, it.category)
            }
    }

    // update
    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO{
        val existingCourse = courseRepository.findById(courseId)

        return if(existingCourse.isPresent){
            existingCourse.get()
                .let {
                    it.name = courseDTO.name
                    it.category = courseDTO.category
                    courseRepository.save(it)
                    CourseDTO(it.id, it.name,it.category)
                }
            }else{
                throw CourseNotFoundException("no course found for passed id: $courseId")
        }
    }

    // delete
    fun deleteCourse(courseId: Int){
        val existingCourse = courseRepository.findById(courseId)
        if(existingCourse.isPresent){
            existingCourse.get()
                .let {
                    courseRepository.deleteById(courseId)
                }
        }else{
            throw CourseNotFoundException("no course found for passed id: $courseId")
        }
    }

}