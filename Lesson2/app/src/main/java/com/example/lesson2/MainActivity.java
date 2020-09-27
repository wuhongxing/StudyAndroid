package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.rxbinding4.view.RxView;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Driver;
import java.sql.Struct;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "FILE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable r = () -> System.out.println("test-----");
        r.run();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CustomActivity.class);
                startActivity(intent);
            }
        });


//        ObjectInputStream objectInputStream = null;
//        try {
//            objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//
//        Score score = new Score(90, 95, 90);
//        Student student = new Student("xiao", 15, score);
//
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(FILE_NAME, MODE_PRIVATE));
//            objectOutputStream.writeObject(student);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

class Student1 implements Parcelable {
    private static final long serialVersionUID = 21321321321312L;
    private String name;
    private int age;
    private Score score;

    protected Student1(Parcel in) {
        name = in.readString();
        age = in.readInt();
        score = in.readParcelable(Score.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(score, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student1> CREATOR = new Creator<Student1>() {
        @Override
        public Student1 createFromParcel(Parcel in) {
            return new Student1(in);
        }

        @Override
        public Student1[] newArray(int size) {
            return new Student1[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class Score1 implements Parcelable {
    private static final long serialVersionUID = 213213213213121232L;

    protected Score1(Parcel in) {
        math = in.readInt();
        English = in.readInt();
        Chinese = in.readInt();
        grade = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(math);
        dest.writeInt(English);
        dest.writeInt(Chinese);
        dest.writeString(grade);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Score1> CREATOR = new Creator<Score1>() {
        @Override
        public Score1 createFromParcel(Parcel in) {
            return new Score1(in);
        }

        @Override
        public Score1[] newArray(int size) {
            return new Score1[size];
        }
    };

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    private int math;
    private int English;
    private int Chinese;
    private String grade;

//    if (math + english + chinese > 270) {
//        grade = "A";
//    }  else if (math + english + chinese > 240) {
//        grade = "B";
//    } else if (math + english + chinese > 210) {
//        grade = "C";
//    } else {
//        grade = "D";
//    }
}





class Student implements Serializable {
    private static final long serialVersionUID = 21321321321312L;
    private String name;
    private int age;
    private Score score;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class Score implements Serializable, Parcelable {
    private static final long serialVersionUID = 213213213213121232L;

    protected Score(Parcel in) {
        math = in.readInt();
        English = in.readInt();
        Chinese = in.readInt();
        grade = in.readString();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    private int math;
    private int English;
    private int Chinese;
    private String grade;

    public Score(int math, int english, int chinese) {
        this.math = math;
        English = english;
        Chinese = chinese;

        if (math + english + chinese > 270) {
            grade = "A";
        }  else if (math + english + chinese > 240) {
            grade = "B";
        } else if (math + english + chinese > 210) {
            grade = "C";
        } else {
            grade = "D";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(math);
        parcel.writeInt(English);
        parcel.writeInt(Chinese);
        parcel.writeString(grade);
    }
}

