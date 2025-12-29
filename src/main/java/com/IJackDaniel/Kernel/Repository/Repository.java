package com.IJackDaniel.Kernel.Repository;

import com.IJackDaniel.Kernel.Model.Habit;
import com.IJackDaniel.Kernel.Model.PeriodType;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Habit> habitList;
    private int lastId;

    public Repository() {
        this.habitList = new ArrayList<>();
        this.lastId = 0;
    }

    public void addHabit(String name, String description, PeriodType periodType) {
        if (isCorrectString(name) && periodType != null) {
            Habit newHabit = new Habit(this.lastId, name, description, periodType);
            this.lastId++;
        } else {
            throw new NullPointerException("Поля 'Название' и 'Периодизация' не должны быть пустыми!");
        }
    }

    public void deleteHabit(int id) {
        if (id >= 0 && id < this.lastId) {
            for (Habit curHabit : this.habitList) {
                if (curHabit.getId() == id) {
                    this.habitList.remove(id);
                    break;
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }
    }

    public Habit findHabit(int id) {
        if (id >= 0 && id < this.lastId) {
            for (Habit curHabit : this.habitList) {
                if (curHabit.getId() == id) {
                    return curHabit;
                }
            }
            return null;
        } else {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }
    }

    private boolean isCorrectString(String string) {
        return (!(string == null || string.isEmpty()));
    }
}
