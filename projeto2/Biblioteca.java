package projeto2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Material> materiais;

    public Biblioteca() {
        this.materiais = new ArrayList<>();
    }

    public void adicionarMaterial(Material material) {
        materiais.add(material);
        System.out.println("Material adicionado com sucesso: " + material.getTitulo());
    }

    public void listarMateriais() {
        for (Material material : materiais) {
            System.out.println(material);
        }
    }

    public Material buscarPorTitulo(String titulo) {
        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }
        return null;
    }

    public List<Material> buscarPorAutor(String autor) {
        List<Material> resultados = new ArrayList<>();
        for (Material material : materiais) {
            if (material.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(material);
            }
        }
        return resultados;
    }

    public boolean removerPorTitulo(String titulo) {
        Material material = buscarPorTitulo(titulo);
        if (material != null) {
            materiais.remove(material);
            return true;
        }
        return false;
    }
}
