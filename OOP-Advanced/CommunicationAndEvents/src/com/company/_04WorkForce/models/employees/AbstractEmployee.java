package com.company._04WorkForce.models.employees;

import com.company._04WorkForce.interfaces.Employee;

public class AbstractEmployee  implements Employee{
        private String name;
        private int workHoursPerWeek;

        public AbstractEmployee(String name) {
            this.setName(name);
        }

        private void setName(String name) {
            this.name = name;
        }

        protected void setWorkHoursPerWeek(int workHoursPerWeek) {
            this.workHoursPerWeek = workHoursPerWeek;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getWorkHoursPerWeek() {
            return this.workHoursPerWeek;
        }
}
