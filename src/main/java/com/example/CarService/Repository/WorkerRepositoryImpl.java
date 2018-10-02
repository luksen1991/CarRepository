package com.example.CarService.Repository;

import com.example.CarService.Domain.Worker;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Transactional
@Component
public class WorkerRepositoryImpl {

    @Transactional
    public Worker addWorker(Worker object) {
        return object;
    }
}
