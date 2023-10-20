package com.archweb.schedule.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.archweb.schedule.models.Schedule;

public interface ScheduleRepository extends
                JpaRepository<Schedule, Integer> {

        @Query("select item from Schedule item left join fetch item.Courses c " +
                        "where item.id = :id ")
        Schedule findScheduleFetchProfessor(@Param("id") Integer id);

}