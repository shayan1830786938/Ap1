public enum CourseDepartment {
    MATH, PHYSICS, CHEMISTERY, CIVIL;

    public static CourseDepartment getEnumByValue(String value){
        switch (value.toLowerCase()){
            case ("math"): return CourseDepartment.MATH;
            case ("physics"): return CourseDepartment.PHYSICS;
            case ("civil"): return CourseDepartment.CIVIL;
            case ("chemistery"): return CourseDepartment.CHEMISTERY;
        }
        return null;
    }
}
