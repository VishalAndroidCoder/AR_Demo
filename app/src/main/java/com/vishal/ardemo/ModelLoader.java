package com.vishal.ardemo;

import android.net.Uri;
import android.util.Log;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.rendering.ModelRenderable;
import java.lang.ref.WeakReference;

// Start the asynchronous loading of the 3D model using the ModelRenderable builder
public class ModelLoader {
    private final WeakReference<MainActivity> owner;
    private static final String TAG = "ModelLoader";

    ModelLoader(WeakReference<MainActivity> owner) {
        this.owner = owner;
    }

    void loadModel(Anchor anchor, Uri uri) {
        if (owner.get() == null) {
            Log.d(TAG, "Activity is null. Cannot load model.");
            return;
        }
        ModelRenderable.builder()
                .setSource(owner.get(), uri)
                .build()
                .handle((renderable, throwable) -> {
                    MainActivity activity = owner.get();
                    if (activity == null) {
                        return null;
                    } else if (throwable != null) {
                        activity.onException(throwable);
                    } else {
                        //  attaches 2 nodes to the ArSceneView's scene object 1. Anchor Node 2. TransformableNode
                        activity.addNodeToScene(anchor, renderable);
                    }
                    return null;
                });
    }
}