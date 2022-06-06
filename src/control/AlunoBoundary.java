package control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application {

    private Label lblId = new Label("ID do Aluno: ");
    private TextField txtId = new TextField();

    private Label lblRa = new Label("RA do Aluno: ");
    private TextField txtRa = new TextField();

    private Label lblNome = new Label("Nome do Aluno: ");
    private TextField txtNome = new TextField();

    private Label lblDataNasc = new Label("Data de nascimento: ");
    private TextField txtDataNasc = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private Aluno[] alunos = new Aluno[100];
    private int indiceAluno = 0;
    //private boolean encontrado=false;

    private void limpaNome(){
        txtId.setText("");
        txtRa.setText("");
        txtNome.setText("");
        txtDataNasc.setText("");
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane panGrid = new GridPane();
        Scene scn = new Scene(panGrid,400,200);

        Label lblAviso = new Label("");

        panGrid.add(lblId,0,0);
        panGrid.add(txtId,1,0);

        panGrid.add(lblRa,0,1);
        panGrid.add(txtRa,1,1);

        panGrid.add(lblNome,0,2);
        panGrid.add(txtNome,1,2);

        panGrid.add(lblDataNasc,0,3);
        panGrid.add(txtDataNasc,1,3);

        panGrid.add(lblAviso,1,4);

        panGrid.add(btnAdicionar,0,5);
        panGrid.add(btnPesquisar,1,5);

        stage.setScene(scn);
        stage.setTitle("Cadastro de Aluno");
        stage.show();

        btnAdicionar.setOnAction(e->{
            Aluno a = new Aluno();
            a.setId(txtId.getText());
            a.setRa(Integer.parseInt(txtRa.getText()));
            a.setNome(txtNome.getText());
            a.setDataNascimento(txtDataNasc.getText());

            alunos[indiceAluno++] = a;

            lblAviso.setText("Aluno Adicionado!");

            limpaNome();
        });

        btnPesquisar.setOnAction(e->{
            for(int i=0;i<=indiceAluno;i++) {
                Aluno a = alunos[i];
                //encontrado=false;

                if (a != null && a.getRa() == Integer.parseInt(txtRa.getText())) {
                    txtId.setText(a.getId());
                    txtRa.setText(Integer.toString(a.getRa()));
                    txtNome.setText(a.getNome());
                    txtDataNasc.setText(a.getDataNascimento());

                    //encontrado = true;

                    lblAviso.setText("Aluno encontrado!");
                }// else if (!encontrado) {
                 //   lblAviso.setText("Aluno não encontrado");
                 //   limpaNome();
                //}
            }
        });
    }
    public static void main(String[] args){
        Application.launch(AlunoBoundary.class, args);
    }
}