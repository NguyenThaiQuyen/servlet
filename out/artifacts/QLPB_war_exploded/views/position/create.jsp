<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <h3>Create new staff</h3>
        </div>
    </div>

    <div class="x_panel">
        <div class="x_content">
            <br />
            <form class="form-horizontal form-label-left">
                <div class="form-group row ">
                    <label class="control-label col-md-3 col-sm-3 ">Full name</label>
                    <div class="col-md-9 col-sm-9 ">
                        <input type="text" class="form-control" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-3 col-sm-3  control-label">Gender
                    </label>

                    <div class="radio custome-radio">
                        <input type="radio" class="flat" checked name="iCheck"> Female
                    </div>
                    <div class="radio custome-radio">
                        <input type="radio" class="flat" name="iCheck"> Male
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-3 col-sm-3 ">Position</label>
                    <div class="col-md-9 col-sm-9 ">
                        <select class="form-control">
                            <option>Giam doc</option>
                            <option>Ke toan</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="control-label col-md-3 col-sm-3 ">Department</label>
                    <div class="col-md-9 col-sm-9 ">
                        <select class="form-control">
                            <option>Nhan su</option>
                            <option>Ke toan</option>
                            <option>Bao ve</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-9 col-sm-9  offset-md-3">
                        <button type="button" class="btn btn-primary">Cancel</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                        <button type="submit" class="btn btn-success">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- /page content -->
<%@ include file="/templates/pages/loadJS.jsp" %>