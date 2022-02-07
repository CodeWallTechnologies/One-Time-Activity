package com.turorials.onetimeactivity.model;

import java.util.List;

public class NewFeedModel {
   String name;
   List<ImageModel> list;


   public NewFeedModel(String name, List<ImageModel> list) {
      this.name = name;
      this.list = list;
   }

   public String getName() {
      return name;
   }

   public List<ImageModel> getList() {
      return list;
   }
}
