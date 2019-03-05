package com.example.a96653.LetsCode;
public final class SchemClass {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private
    private SchemClass() {}

    /* Inner class that defines the table contents */
    public static class LetsCode2 {
        public static final String TABLE_NAME = "Child";
        public static final String COLUMN_NAME_ChildName = "Name";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_Score = "Score";


        public static final String SECOND_TABLE="LEVEL";
        public static final String COLUMN_NAME_LevelName="LevelName";
        public static final String COLUMN_NAME_LessonsPassed="NumOfLessonsPassed";
        public static final String COLUMN_NAME_LEVELSTATUS="LevelStatus";

        public static final String THIRD_TABLE="LESSON";
        public static final String COLUMN_NAME_LESSON_NUM="LESSON_NUM";
        // public static final String COLUMN_NAME_CONTENT="CONTENT";


        public static final String WELCOME_TABLE="Welcome_Progress";
        public static final String WELCOME_INTERFACE_NAME="InterfaceName";
        public static final String WELCOME_INTERFACE_STATUS="Status";


        public static final String Table_Quiz="QUIZ";
        public static final String COLUMN_NAME_QUIZID="QuizID";
        public static final String COLUMN_NAME_QUIZRESULT="QuizResult";

        public static final String TABLE_AUESTION="QUESTION";
        public static final String COLUMN_NAME_QNUM="QNUM";
        public static final String COLUMN_NAME_QANSWER="Q_ANSWER";


        public static final String INDEX_TABLE2="QUESINDEX2";
        public static final String COLUMN_NAME_QUESTION="Question";

        public static final String TABLE_IMAGE= "PIC"; //كود جديد


    }
}