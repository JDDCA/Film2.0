package com.gmail.nf.project.jddca.film20.ui.generate.dagger;

import com.gmail.nf.project.jddca.film20.ui.generate.GenerateFragment;

import dagger.Subcomponent;

@Subcomponent (modules = {GenerateModule.class})
public interface GenerateComponent {
    void inject (GenerateFragment fragment);
}
