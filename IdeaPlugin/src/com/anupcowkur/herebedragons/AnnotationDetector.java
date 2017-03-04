package com.anupcowkur.herebedragons;

import com.intellij.codeInsight.AnnotationUtil;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiModifierListOwner;

public final class AnnotationDetector {

    private AnnotationDetector() {
    }

    public static boolean hasAnnotation(PsiElement element, String annotationName) {
        return findAnnotation(element, annotationName) != null;
    }

    static PsiAnnotation findAnnotation(PsiElement element, String annotationName) {
        if (element instanceof PsiModifierListOwner) {
            PsiModifierListOwner listOwner = (PsiModifierListOwner) element;
            PsiModifierList modifierList = listOwner.getModifierList();

            if (modifierList != null) {
                for (PsiAnnotation psiAnnotation : modifierList.getAnnotations()) {
                    if (annotationName.equals(psiAnnotation.getQualifiedName())) {
                        return psiAnnotation;
                    }
                }
            }

        }
        return null;
    }
}
