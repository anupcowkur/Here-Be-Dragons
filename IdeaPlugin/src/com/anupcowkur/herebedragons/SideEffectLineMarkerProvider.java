package com.anupcowkur.herebedragons;

import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiTypeElement;

import java.util.Collection;
import java.util.List;
import javax.swing.Icon;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.anupcowkur.herebedragons.AnnotationFinder.hasAnnotation;
import static com.anupcowkur.herebedragons.Constants.CLASS_SIDE_EFFECT;
import static com.intellij.codeHighlighting.Pass.UPDATE_ALL;
import static com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.LEFT;

public class SideEffectLineMarkerProvider implements LineMarkerProvider {
    private static final Icon ICON = IconLoader.getIcon("/icons/dragon.png");

    /**
     * @return a {@link com.intellij.codeInsight.daemon.GutterIconNavigationHandler} if the element
     * is a PsiMethod annotated with @SideEffect.
     */
    @Nullable
    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull final PsiElement element) {
        // Check methods first (includes constructors).
        if (element instanceof PsiMethod) {
            PsiMethod methodElement = (PsiMethod) element;

            // Does it have a @SideEffect?
            if (hasAnnotation(element, CLASS_SIDE_EFFECT)) {
                PsiTypeElement returnTypeElement = methodElement.getReturnTypeElement();
                if (returnTypeElement != null) {
                    return new LineMarkerInfo<PsiElement>(element, returnTypeElement.getTextRange(), ICON,
                            UPDATE_ALL, null, null, LEFT);
                }
            }
        }

        return null;
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> psiElements,
                                       @NotNull Collection<LineMarkerInfo> lineMarkerInfos) {

    }
}