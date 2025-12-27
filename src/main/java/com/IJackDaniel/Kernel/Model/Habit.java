package com.IJackDaniel.Kernel.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Habit {
    private final long id;
    private final String name;
    private final String description;
    private final PeriodType periodType;
    private final LocalDate createdDate;
    private final List<LocalDate> completions;

    public Habit (long id, String name, String description, PeriodType periodType) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }

        this.id = id;
        this.name = Objects.requireNonNull(name, "Name can't be null");
        this.description = description;
        this.periodType = Objects.requireNonNull(periodType, "PeriodType can't be null");
        this.createdDate = LocalDate.now();
        this.completions = new ArrayList<>();
    }

    public void addCompletion(LocalDate completionDate) {
        Objects.requireNonNull(completionDate, "Completion date can't be null");
        if (!this.completions.contains(completionDate)) {
            this.completions.add(completionDate);
        }
    }

    public boolean isCompleteOn(LocalDate date) {
        return this.completions.contains(date);
    }

    public int getCompletionsCount() {
        return this.completions.size();
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public List<LocalDate> getCompletions() {
        return Collections.unmodifiableList(completions);
    }

    // Override
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Habit habit = (Habit) object;
        return id == habit.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Habit{" +
                "\nid:" + id +
                ", \nname:" + name +
                ", \ndescription:" + description +
                ", \nperiod:" + periodType +
                ", \ncompletionsCount:" + completions.size()+
                "}";
    }
}
