/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.validations;

import com.supinfo.rmt.models.WorkTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author alexis
 */
public class WorkTimeValidator implements ConstraintValidator<WorkTimeConstraint, WorkTime> {

    @Override
    public void initialize(WorkTimeConstraint a) {
        
    }

    @Override
    public boolean isValid(WorkTime t, ConstraintValidatorContext cvc) {
        return t.getBeginDate().before(t.getEndDate());
    }

    
}
