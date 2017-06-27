package com.scw.kindergarten.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scw.kindergarten.model.Uprawnienie;
import com.scw.kindergarten.repository.UprawnienieRepository;
import com.scw.kindergarten.view.utils.Utils;


@Component("uprawnienieView")
@ViewScoped
public class UprawnienieView implements Serializable
{

  private static final long serialVersionUID = 1L;

  @Autowired
  private UprawnienieRepository uprawnienieRepository;

  private TreeNode[] selectedPermissionNode;
  private String perName;
  private String perComp;
  private TreeNode root;

  @PostConstruct
  public void init()
  {
    Iterable<Uprawnienie> uprawnienia = uprawnienieRepository.findAll();

    root = new DefaultTreeNode(new Uprawnienie(),null);
    for (Uprawnienie uprawnienie : uprawnienia)
    {
      new DefaultTreeNode(uprawnienie,root);
    }
  }

  public void permissionEdit(RowEditEvent event)
  {
    FacesMessage msg = new FacesMessage("Document Edited",((TreeNode)event.getObject()).toString());
    FacesContext.getCurrentInstance().addMessage(null,msg);
  }

  public void permissionEditCancel(RowEditEvent event)
  {
    FacesMessage msg = new FacesMessage("Edit Cancelled",((TreeNode)event.getObject()).toString());
    FacesContext.getCurrentInstance().addMessage(null,msg);
  }

  public void delete()
  {
    Utils.addDetailMessage(selectedPermissionNode.length + " cars deleted successfully!");
  }

  public void clear()
  {
    perName = null;
    perComp = null;
  }
  public void save()
  {
    Utils.addDetailMessage("Nowe uprawnienie dodane " + perName + ", " + perComp,FacesMessage.SEVERITY_INFO);
    clear();
  }

  public TreeNode getRoot()
  {
    return root;
  }

  public void setRoot(TreeNode root)
  {
    this.root = root;
  }

  public String getPerName()
  {
    return perName;
  }

  public void setPerName(String perName)
  {
    this.perName = perName;
  }

  public String getPerComp()
  {
    return perComp;
  }

  public void setPerComp(String perComp)
  {
    this.perComp = perComp;
  }

  public TreeNode[] getSelectedPermissionNode()
  {
    return selectedPermissionNode;
  }

  public void setSelectedPermissionNode(TreeNode[] selectedPermissionNode)
  {
    this.selectedPermissionNode = selectedPermissionNode;
  }

}
