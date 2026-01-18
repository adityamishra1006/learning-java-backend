package org.example;


import org.apache.maven.api.plugin.annotations.Mojo;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;


@Mojo(name = "check-interface-naming", defaultPhase = "VALIDATE")
public class InterfaceNamingConventionMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException{
        File srcDir = new File("src/main/java");
        if(!srcDir.exists() || !srcDir.isDirectory()){
            getLog().warn("No source directory found");
            return;
        }
        checkDirectory(srcDir);

    }

    private void checkDirectory(File directory) throws MojoExecutionException{
        File[] files = directory.listFiles();
        if(files == null) {
            return;
        }

        for(File file : files) {
            if(file.isDirectory()) {
                checkDirectory(file);
            } else if(file.getName().endsWith(".java")) {
                validateJavaFile(file);
            }
        }
    }

    private void validateJavaFile(File file) throws MojoExecutionException{
        try {
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            if(content.contains("interface")) {
                String fileName = file.getName();
                if(!fileName.endsWith("Interface.java")) {
                    throw new MojoExecutionException("Interface naming convention violation in file : " + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            throw new MojoExecutionException("Error reading file: " + file.getAbsolutePath(), e);
        }
    }
}
