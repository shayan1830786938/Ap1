public enum CourseType {
    Takhsossi, Omomii;

    public static CourseType getEnumByValue(String value) {
        switch (value.toLowerCase()) {
            case ("1"):
                return CourseType.Takhsossi;
            case ("2"):
                return CourseType.Omomii;
        }
        return null;
    }
}
