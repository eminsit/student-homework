/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.config;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eminsit
 */
@ApplicationScoped
@ManagedBean
public class Parameters {

  public String rootPro = "/student/";

  public String getRootPro() {
    return rootPro;
  }

}
