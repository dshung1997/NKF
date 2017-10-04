package com.example.tp_baseline.nkf;

import java.util.ArrayList;

/**
 * Created by dshung on 03/10/2017.
 */

public class LessonLibrary {

    ArrayList<Lesson> lessons;

    public LessonLibrary()
    {
        lessons = new ArrayList<Lesson>();
        lessons.add(new Lesson(
            "Lesson 1 : What are kidneys ?",
            "9PsNgOXPUz0",
            "Human kidneys............",
            "https://image.ibb.co/imfkTw/les1.png",
            new Quiz[]{
                    new Quiz("What is kidney ?", new String[]{"2 bean bags", "2 bean shaped organs", "2 lung-shaped organs", "something that protects fats"}, "2 bean shaped organs"),
                    new Quiz("What is the average size of a kidney ?", new String[]{"a soccer ball", "a size of your fist", "a size of an eraser", "a size of your eyeball"}, "a size of your fist"),
                    new Quiz("Where is your kidney located ?", new String[]{"Below your ribcage, one on each side of the spine", "Beside your heart, on on the left and the other on the right", "Behind your lungs", "At the side of your waist"}, "Below your ribcage, one on each side of the spine"),
                    new Quiz("How much quarts of blood does your 2 kidneys filter every day ?", new String[]{"40-70", "70-100", "120- 150", "150-180"}, "120- 150")
            }
        ));

        lessons.add(new Lesson(
            "Lesson 2 : Why are kidneys important ?",
            "f6kZXdmNafc",
            "Because...........",
            "https://image.ibb.co/ch1nab/les2.png",
            new Quiz[]{
                    new Quiz("Which of the following is correct ?", new String[]{"Kidney prevents buildup of wastes and extra fluid in the body", "Kidney helps pump blood into your heart", "Kidney acts as a support to digest your food", "Kidney prevents buildup of urine"}, "Kidney prevents buildup of wastes and extra fluid in the body"),
                    new Quiz("Fill in the missing blank(s).\n\nBlood, waste and water enter through ______", new String[]{"renal vein", "pulmonary", "left atrium", "renal artery"}, "renal artery"),
                    new Quiz("Fill in the missing blank(s).\n\nBlood without waste/excess water leave through ______", new String[]{"renal vein", "right atrium", "blood stream", "urine"}, "renal vein"),
                    new Quiz("Fill in the missing blank(s).\n\nExcess water & ______ in the form of ____ leaves via ureter.", new String[]{"toxic waste, urine", "toxic water, blood", "urine, blood", "poop, urine"}, "toxic waste, urine")
            }
        ));

        lessons.add(new Lesson(
                "Lesson 3 : Chronic Kidney Disease",
                "8Gwy8CjNRNQ",
                "......................",
                "https://image.ibb.co/duwaTw/les3.png",
                new Quiz[]{
                        new Quiz("How many filtering units are in the kidney ?", new String[]{"1,000,000", "100,000", "1,000", "100"}, "1,000,000"),
                        new Quiz("What do the nephrons contain ?", new String[]{"tuft of capilaries called a glomerulus", "renal corpuscle", "renal tubule", "microscopic structural"}, "..."),
                        new Quiz("What is the function of the gloerulus ?", new String[]{"pumps blood into the kidney", "pumps blood into the heart", "allows fluid and waste products pass through", "allows fluid and poop to pass through"}, "..."),
                        new Quiz("How many nephrons do we have ?", new String[]{"1,000,000", "1", "100", "2"}, "...")
                }
        ));

        lessons.add(new Lesson(
                "Lesson 4 : How to prevent kidney failure ?",
                "wI2rlf4tdUU",
                "............................",
                "https://image.ibb.co/g1tB1G/les4.png",
                new Quiz[]{
                        new Quiz("What is the correct cause of Chronic Kidney Disease ?", new String[]{"Diabetes", "Low blood pressure", "Sweet Tooth", "Damaged kidneys"}, "Diabetes"),
                        new Quiz("What is Chronic Kidney Disease also known as ?", new String[]{"Chronic renal disease", "Chronic vein disease", "Chronic pulmonary disease", "Chronic liver disease"}, "Chronic renal disease"),
                        new Quiz("What is one correct symptom of CKD ?", new String[]{"tiredness", "swollen eyes", "loss of blood", "good appetite"}, "tiredness"),
                        new Quiz("What will surface on our body when the kidney is damaged ?", new String[]{"swelling in ankles", "good appetite", "swelling in eye, causing puffy eyes", "loss of hair"}, "swelling in ankles")
                }
        ));
    }

    public Lesson getLesson(int pos)
    {
        return lessons.get(pos);
    }

//    public Boolean addLesson(Lesson ls)
//    {
//        return lessons.add(ls);
//    }
}

class Lesson {
    String urlVideo;
    String title;
    String description;

    String urlImage;
    Quiz[] quizs;

    public Lesson(String _title, String _urlVideo, String _description, String _urlImage, Quiz[] _quizs)
    {
        title = _title;
        description = _description;
        urlImage = _urlImage;
        quizs = _quizs;
        urlVideo = _urlVideo;
    }

    public static String getRelativeURL(String _url)
    {
        String h = _url.replace("https://www.youtube.com/watch?v=", "");
        return h;
    }

}
