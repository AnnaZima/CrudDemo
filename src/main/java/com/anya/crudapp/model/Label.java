package com.anya.crudapp.model;

public class Label {
     private Integer id;
     private String name;
     private Status status = Status.ACTIVE;

     public Label() {
     }

     public Label(String name) {
          this.name = name;
     }

     public Label(Integer id, String name, Status status) {
          this.id = id;
          this.name = name;
          this.status = status;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Status getStatus() {
          return status;
     }

     public void setStatus(Status status) {
          this.status = status;
     }

     @Override
     public String toString() {
          return "Label{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  '}';
     }

}
