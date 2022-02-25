package com.turorials.onetimeactivity.model;

import java.util.List;

public class NewFeedModel {
   String name;
   List<ChildLessonModel> list;




   public void setName(String name) {
      this.name = name;
   }

   public void setList(List<ChildLessonModel> list) {
      this.list = list;
   }

   public String getName() {
      return name;
   }

   public List<ChildLessonModel> getList() {
      return list;
   }
}
