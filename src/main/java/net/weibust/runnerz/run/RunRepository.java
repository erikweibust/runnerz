package net.weibust.runnerz.run;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface RunRepository extends ListCrudRepository<Run, Integer> {

    List<Run> findAllByLocation(String location);

    @Query("select * from run where location = 'OUTDOOR'")
    List<Run> findAllOutdoorRuns();

}
