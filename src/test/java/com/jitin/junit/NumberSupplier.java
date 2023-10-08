package com.jitin.junit;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jitin on 25/03/2017.
 */
public class NumberSupplier extends ParameterSupplier {


    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();

        list.add(PotentialAssignment.forValue("long",2L));
        list.add(PotentialAssignment.forValue("float",5.00f));
        list.add(PotentialAssignment.forValue("double",89d));
        return list;
    }
}
