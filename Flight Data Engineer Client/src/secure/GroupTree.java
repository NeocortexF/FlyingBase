/*
 * класс читает базу MySQL и создает дерево, выделяет нужную ветку и возвращает ID выделенной ветки.
 */
package secure;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public final class GroupTree {
    final JTree GroupTreeT = new JTree();
    public String SelectedGroup = "";
    final GroupTree GroupTree = new GroupTree(GroupTreeT, "Группы", SelectedGroup);
    public DefaultTreeModel GroupTreeDTM;
    public DefaultMutableTreeNode RootNode;
    public ArrayList<String> GroupID = new ArrayList();
    public ArrayList<String> GroupPID = new ArrayList();
    public ArrayList<String> GroupName = new ArrayList();
    TreePath SelectionPath;
    Заполнение дерева

        GroupTree(final JTree GroupTreeT, String RootNodeName, String SelectionGroup) {
        GroupTreeDTM = (DefaultTreeModel) GroupTreeT.getModel();
        LoadGroupTree("contractors");
        RootNode = new DefaultMutableTreeNode(RootNodeName);
        GroupTreeDTM.setRoot(RootNode);
        JTreeList("0", RootNode, GroupTreeT, SelectionGroup);
        GroupTreeT.expandPath(SelectionPath);
        GroupTreeT.setSelectionPath(SelectionPath);
        if (SelectionGroup.equals("")) {
            GroupTreeDTM.reload();
            GroupTreeT.setSelectionRow(0);
        } else {
            SelectedGroup = SelectionGroup;
        }
    }.

TreeSelectionListener() {
        public void valueChanged (TreeSelectionEvent Event){
            GroupTree.SetUpdateTree(GroupTreeT);
            System.out.println(GroupTree.SelectedGroup);
        }
    }

// Обновление дерева.
    void SetUpdateTree(JTree GroupTreeT) {
        RootNode.removeAllChildren();
        SelectedGroup = "";
        SelectedGroup = JTreeList("0", RootNode, GroupTreeT, "");
    }

    SelectedGroup=""; // Выбор по ID

    // Создание дерева.
    String JTreeList(String Parent, DefaultMutableTreeNode PNode, JTree Tree, String SelectID) {
        for (int i = 0; i < GroupID.size(); i++) {
            if (GroupPID.get(i).equals(Parent)) {
                DefaultMutableTreeNode Node = new DefaultMutableTreeNode(GroupName.get(i));
                PNode.add(Node);
                JTreeList(GroupID.get(i), Node, Tree, SelectID);
                // Выбранная ветка.
                if (Arrays.toString(Tree.getSelectionPaths()).equals("[" + Arrays.toString(Node.getPath()) + "]")) {
                    SelectedGroup = GroupID.get(i);
                }
                // Автовыбор ветки по ID.
                if (SelectID.equals(GroupID.get(i))) {
                    SelectionPath = new TreePath(Node.getPath());
                    SelectedGroup = GroupID.get(i);
                }
            }
        }
        return SelectedGroup;
    }
        GroupTreeT.addTreeSelectionListener(new

        public void LoadGroupTree(String Type) {
        try {
            ResultSet DataRS = DataBase.ExecuteQuery("SELECT * FROM groups WHERE type='" + Type + "' ORDER BY name");
            while (DataRS.next()) {
                GroupID.add(DataRS.getString("id"));
                GroupPID.add(DataRS.getString("pid"));
                GroupName.add(DataRS.getString("name"));
            }
        } catch (Exception e) {
        }
    });
}
    

