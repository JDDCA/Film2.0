package com.gmail.nf.project.jddca.film20.ui.filter.dagger;

import com.gmail.nf.project.jddca.film20.ui.filter.FilterFragment;

import dagger.Subcomponent;

@Subcomponent (modules = {FilterModule.class})
public interface FilterComponent {

    void inject (FilterFragment filterFragment);
}
