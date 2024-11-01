package hgeom.hmesh.core;

import hgeom.hmesh.data.HDData;
import hgeom.hmesh.elements.HFace;
import hgeom.hmesh.elements.HMesh2D;
import hgeom.hmesh.elements.HVertex;
import java.util.List;

/**
 * @author Pierre B.
 */
final class HMesh2DImpl extends HMeshImpl implements HMesh2D {

  /**
   *
   */
  private final HDData<HVertex> xs;

  /**
   *
   */
  private final HDData<HVertex> ys;

  /**
   * @param faces
   * @param elementFactory
   */
  public HMesh2DImpl(List<HFace> faces, HElementFactory elementFactory) {
    super(faces, elementFactory);
    this.xs = elementFactory.createVertexDoubleData(this);
    this.ys = elementFactory.createVertexDoubleData(this);
  }

  @Override
  public HDData<HVertex> vertexXs() {
    return xs;
  }

  @Override
  public HDData<HVertex> vertexYs() {
    return ys;
  }

  @Override
  public double vertexX(HVertex v) {
    return xs.get(v);
  }

  @Override
  public void setVertexX(HVertex v, double x) {
    xs.set(v, x);
  }

  @Override
  public double vertexY(HVertex v) {
    return ys.get(v);
  }

  @Override
  public void setVertexY(HVertex v, double y) {
    ys.set(v, y);
  }

  @Override
  public double[] vertexXY(HVertex v, double[] xy) {
    double[] result = xy == null ? new double[2] : xy;
    result[0] = xs.get(v);
    result[1] = ys.get(v);
    return result;
  }

  @Override
  public void setVertexXY(HVertex v, double[] xy) {
    xs.set(v, xy[0]);
    ys.set(v, xy[1]);
  }

  @Override
  public void setVertexXY(HVertex v, double x, double y) {
    xs.set(v, x);
    ys.set(v, y);
  }
}
