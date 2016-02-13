<hr>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.6.15/browser.js"></script>
    <div id="pcchr-content"></div>
    <script type="text/babel">

var PcchrBox = React.createClass({
  loadCommentsFromServer: function() {
    var pcchr_url = this.props.geturl + '&patientId=' + this.props.patientid;
    jQuery.ajax({
      url: pcchr_url,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(err.toString());
      }.bind(this)
    });
  },

  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
    this.loadCommentsFromServer();
    setInterval(this.loadCommentsFromServer, this.props.pollInterval);
  },
  render: function() {
    return (
      <div className="pcchrBox">
        <PcchrForm posturl={this.props.posturl} patientid={this.props.patientid} onCommentSubmit={this.handleCommentSubmit} />
        <PcchrList data={this.state.data} />
      </div>
    );
  }
});

var PcchrForm = React.createClass({
  handleCommentSubmit: function(comment) {
    comment.dataType = 'N';
    comment.dataNs = 'SNOMED - CT';
    comment.dataUnitNs = 'SNOMED - CT';
    comment.patientId = this.props.patientid;
    comment.numData = parseFloat(comment.numData);
    jQuery.ajax({
      url: this.props.posturl,
      dataType: 'json',
      type: 'POST',
      returnFormat: 'json',
      data: comment,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(err.toString());
      }.bind(this)
    });
  },

  render: function() {
    return (
      <div className="pcchrBox">
        <BloodSugarForm onCommentSubmit={this.handleCommentSubmit} />
        <BodyWeightForm onCommentSubmit={this.handleCommentSubmit} />
      </div>
    );
  }

});

var Pcchr = React.createClass({
  handleClick: function() {   
    var comment = {};
    comment.id = this.props.id;
    jQuery.ajax({
      url: '${ ui.actionLink("purgeHl10") }',
      dataType: 'json',
      type: 'POST',
      returnFormat: 'json',
      data: comment,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(err.toString());
      }.bind(this)
    });
  },

  render: function() {
    return (
        <tr>
            <td>{this.props.dataName} | </td>
            <td>{this.props.dataCode} | </td>
            <td>{this.props.startTime} | </td>
            <td>{this.props.numData} | </td>
            <td>
                <p onClick={this.handleClick}>Delete</p>
            </td>
        </tr>
    );
  }
});


var PcchrList = React.createClass({
  render: function() {
    var commentNodes = this.props.data.map(function(comment) {
      return (
        <Pcchr 
        dataName={comment.dataName} 
        dataCode={comment.dataCode} 
        startTime={comment.startTime} 
        numData={comment.numData} 
        id={comment.id}>         
        </Pcchr>
      );
    });
    return (
      <div className="commentList">

        <table className="table-bordered table-striped table-responsive">
            <thead>
            <tr>
                <th>Name</th>
                <th>Code</th>
                <th>Date</th>
                <th>Value</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

                {commentNodes}
            </tbody>
        </table>
        
      </div>
    );
  }
});




var BloodSugarForm = React.createClass({
  getInitialState: function() {
    return {pcchr: ''};
  },
  handlePcchrChange: function(e) {
    this.setState({pcchr: e.target.value});
  },
  handleSubmit: function(e) {
    e.preventDefault();
    var pcchr = this.state.pcchr.trim();
    var data_name = 'Blood Sugar';
    var data_code = '144194009';
    if (!pcchr) {
      return;
    }
    this.props.onCommentSubmit({dataName: data_name, dataCode: data_code, numData: pcchr});
    this.setState({pcchr: ''});
  },
  render: function() {
    return (
      <form className="pcchrForm" onSubmit={this.handleSubmit}>
      <div className="input-group">
        <input value={this.state.pcchr} onChange={this.handlePcchrChange} id="glucose" type="text" className="form-control" placeholder="Your Blood Glucose Reading" />
        <span className="input-group-addon" id="basic-addon2">mg/DL</span>
        <input type="submit" className="btn btn-success pull-right" id="GlucoseSave" />
      </div>
      </form>
    );
  }
});

var BodyWeightForm = React.createClass({
  getInitialState: function() {
    return {pcchr: ''};
  },
  handlePcchrChange: function(e) {
    this.setState({pcchr: e.target.value});
  },
  handleSubmit: function(e) {
    e.preventDefault();
    var pcchr = this.state.pcchr.trim();
    var data_name = 'Body Weight';
    var data_code = '27113001';
    if (!pcchr) {
      return;
    }
    this.props.onCommentSubmit({dataName: data_name, dataCode: data_code, numData: pcchr});
    this.setState({pcchr: ''});
  },
  render: function() {
    return (
      <form className="pcchrForm" onSubmit={this.handleSubmit}>
      <div className="input-group">
        <input value={this.state.pcchr} onChange={this.handlePcchrChange} id="weight" type="text" className="form-control" placeholder="Your Weight" />
        <span className="input-group-addon" id="basic-addon3">Kg</span>
        <input type="submit" className="btn btn-success pull-right" id="WeightSave" />
      </div>
      </form>
    );
  }
});


        ReactDOM.render(
          <PcchrBox geturl="${ ui.actionLink("getAllHl10", [returnFormat: "json"]) }" 
          patientid="${ patient.id }" 
          posturl="${ ui.actionLink("saveHl10") }" pollInterval={5000} />,
          document.getElementById('pcchr-content')
        );

    </script>

