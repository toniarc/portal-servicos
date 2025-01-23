package br.com.portalservicos.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class AttributeError {
    private String name;
    private List<String> errors = new ArrayList<>();

    public AttributeError(String name) {
        this.name = name;
    }

    public AttributeError(String name, String error) {
        this.name = name;
        this.errors.add(error);
    }

    public boolean hasErros(){
        return !errors.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeError that = (AttributeError) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
