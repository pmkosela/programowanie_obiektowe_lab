public class TransformationDecorator extends ShapeDecorator{
    private boolean translate;
    private Vec2 translateVector;

    private boolean rotate;
    private double rotateAngle;
    private Vec2 rotateCenter;

    private boolean scale;
    private Vec2 scaleVector;

    public TransformationDecorator(Shape shape){
        super(shape);
    }

    public String toSvg(String parameters){
        String output = "";
        if(translate == true){
            String translation = String.format("translate(%f %f) ", translateVector.x, translateVector.y);
            output += translation;
        }
        if(rotate == true){
            String rotation = String.format("rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y);
            output += rotation;
        }
        if(scale == true){
            String scaling = String.format("scale(%f %f) ", scaleVector.x, scaleVector.y);
            output += scaling;
        }
        output = String.format("\"transform=\\\"%s\\\" %s\"", output, parameters);
        return super.toSvg(output);

    }
    public class Builder{
        private boolean translate;
        private Vec2 translateVector;

        private boolean rotate;
        private double rotateAngle;
        private Vec2 rotateCenter;

        private boolean scale;
        private Vec2 scaleVector;

        private Shape shape;

        public Builder setTranslateVector(Vec2 translateVector) {
            this.translateVector = translateVector;
            this.translate = true;
            return this;
        }

        public Builder setRotateAngle(double rotateAngle) {
            this.rotateAngle = rotateAngle;
            this.rotate = true;
            return this;
        }

        public Builder setRotateCenter(Vec2 rotateCenter) {
            this.rotateCenter = rotateCenter;
            this.rotate = true;
            return this;
        }

        public Builder setScaleVector(Vec2 scaleVector) {
            this.scaleVector = scaleVector;
            this.scale = true;
            return this;
        }
        public TransformationDecorator build(Shape shape)
        {
            TransformationDecorator output = new TransformationDecorator(shape);

            if(output.rotate = this.rotate) {
                output.rotateAngle = this.rotateAngle;
                output.rotateCenter = this.rotateCenter;
            }
            if(output.scale = this.scale) {
                output.scaleVector = this.scaleVector;
            }
            if(output.translate = this.translate){
                output.translateVector = this.translateVector;
            }
            return output;


        }
    }

}
