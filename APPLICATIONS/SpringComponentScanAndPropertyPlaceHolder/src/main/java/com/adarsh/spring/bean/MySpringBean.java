package com.adarsh.spring.bean;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MySpringBean {

  private String name;

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  @Override
  public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("MySpringBean");
      sb.append("{name='").append(name).append('\'');
      sb.append('}');
      return sb.toString();
  }
}
